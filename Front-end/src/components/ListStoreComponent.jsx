import React, { Component } from 'react';
import StoreService from '../services/StoreService';

class ListStoreComponent extends Component {
    constructor(props){
        super(props)

        this.state = {
                stores: []
        }

        this.addStore = this.addStore.bind(this);
        this.editStore = this.editStore.bind(this);
        this.deleteStore = this.deleteStore.bind(this);
        this.returnToMain = this.returnToMain.bind(this);
    }

    componentDidMount(){
        StoreService.getStores().then((res) => {
            this.setState({stores: res.data});
        });
    }

    returnToMain(){
        this.props.history.push("/");
    }

    addStore(){
        this.props.history.push("/add-store");
    }

    editStore(id){
        this.props.history.push(`/update-store/${id}`);        
    }

    deleteStore(id){
        StoreService.deleteStore(id).then( res => {
            this.setState({stores: this.state.stores.filter(store => store.id !== id)});
        });
    }


    render() {
        return (
            <div>
                <h2 className="text-center">Stores List</h2>
                <div className = "row">
                    <button className="btn btn-primary" onClick={this.addStore}>Add Store</button>
                </div>
                <div classNmae = "row">
                    <table className="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th> Store Name</th>
                                <th> Store Initial Revenue</th>
                                <th> Store Current Revenue</th>
                                <th> Actions</th>
                            </tr>
                        </thead>

                        <tbody>
                            {
                                this.state.stores.map(
                                    store =>
                                    <tr key = {store.id}>
                                        <td> {store.storeName}</td>
                                        <td> {store.initialRevenue}</td>
                                        <td> {store.currentRevenue}</td>
                                        <td>
                                            <button onClick = { () => this.editStore(store.id)} className = "btn btn-info">Update </button>
                                            <button style={{marginLeft: "10px"}} onClick = { () => this.deleteStore(store.id)} className = "btn btn-danger">Delete </button>
                                        </td>
                                    </tr>

                                )
                            }
                        </tbody>

                    </table>
                </div>

                <div className = "row">
                    <button className="btn btn-primary" onClick={this.returnToMain}>Return</button>
                </div>
                
            </div>
        );
    }
}

export default ListStoreComponent;