import React, { Component } from 'react';
import StoreService from '../services/StoreService';

class CreateStoreComponent extends Component {
    constructor(props){
        super(props)

        this.state = {
            storeName:'',
            initialRevenue:'',
            currentRevenue:''
        }
        this.changeStoreNameHandler = this.changeStoreNameHandler.bind(this);
        this.changeInitialRevenueHandler = this.changeInitialRevenueHandler.bind(this);
        this.changeCurrentRevenueHandler = this.changeCurrentRevenueHandler.bind(this);
        this.saveStore = this.saveStore.bind(this);
    }

    saveStore = (e) =>{
        e.preventDefault();
        let store = {storeName: this.state.storeName, initialRevenue: this.state.initialRevenue, currentRevenue: this.state.currentRevenue};
        console.log('store => ' + JSON.stringify(store));

        StoreService.createStore(store).then(res =>{
            this.props.history.push("/stores");
        })
    }

    cancel(){
        this.props.history.push("/stores");
    }
    
    changeStoreNameHandler= (event) => {
        this.setState({storeName: event.target.value});
    }

    changeInitialRevenueHandler= (event) => {
        this.setState({initialRevenue: event.target.value})
    }

    changeCurrentRevenueHandler= (event) => {
        this.setState({currentRevenue: event.target.value})
    }
    
    render() {
        return (
            <div>
                <div className='container'>
                    <div className='row'>
                        <div className='card col-md-6 offset-md-3 offset md-3'>
                            <h3 className='text-center'>Add Store</h3>
                            <div className='card-body'>
                                <form>
                                    <div className='form-group'>
                                        <label>Store Name:</label>
                                        <input placeholder='Store Name' name='storeName' className='form-control'
                                            value={this.state.storeName} onChange={this.changeStoreNameHandler}/>
                                    </div>
                                    <div className='form-group'>
                                        <label>Initial Revenue:</label>
                                        <input placeholder='Initial Revenue' name='initialRevenue' className='form-control'
                                            value={this.state.initialRevenue} onChange={this.changeInitialRevenueHandler}/>
                                    </div>
                                    <div className='form-group'>
                                        <label>Current Revenue:</label>
                                        <input placeholder='Current Revenue' name='currentRevenue' className='form-control'
                                            value={this.state.currentRevenue} onChange={this.changeCurrentRevenueHandler}/>
                                    </div>
                                    <button className='btn btn-success' onClick={this.saveStore}>Save</button>
                                    <button className='btn btn-danger' onClick={this.cancel.bind(this)} style={{marginLeft:'10px'}}>Cancel</button>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default CreateStoreComponent;