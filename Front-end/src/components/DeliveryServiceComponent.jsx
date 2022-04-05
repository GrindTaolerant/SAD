import React, { Component } from 'react';

class DeliveryServiceComponent extends Component {
    constructor(props){
        super(props)

        this.state = {
            
        }

        this.goStore = this.goStore.bind(this);
    }


    goStore(){
        this.props.history.push("/stores");
    }


    render() {
        return (
            <div>
                <h2 className="text-center">Delivery Service</h2>
                <div className = "row">
                    <button className="btn btn-primary" onClick={this.goStore}>Store</button>
                    <button style={{marginTop: "20px"}}  className="btn btn-primary" onClick={this.goCustomer}>Customer</button>
                    <button style={{marginTop: "20px"}}  className="btn btn-primary" onClick={this.goPilot}>Pilot</button>

                    <button style={{marginTop: "150px"}}  className="btn btn-danger" onClick={this.shutDown}>Shut Down</button>
                </div> 


            </div>
        );
    }
}

export default DeliveryServiceComponent;