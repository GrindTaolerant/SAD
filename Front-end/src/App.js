import logo from './logo.svg';
import './App.css';
import ListStoreComponent from './components/ListStoreComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import CreateStoreComponent from './components/CreateStoreComponent';
import UpdateStoreComponent from './components/UpdateStoreComponent';
import DeliveryServiceComponent from './components/DeliveryServiceComponent';

function App() {
  return (
    <div>
      <Router>
      
          <HeaderComponent />
    
            <div className="container">
                <Switch> 
                  <Route path = "/" exact component = {DeliveryServiceComponent}></Route>
                
                  <Route path = "/stores" component = {ListStoreComponent}></Route>
                  <Route path = "/add-store" component = {CreateStoreComponent}></Route>
                  <Route path = "/update-store/:id" component = {UpdateStoreComponent}></Route>
                  <ListStoreComponent /> 
                </Switch>   
            </div>
          <FooterComponent />  
        
      </Router>
    </div>   
    
  );
}

export default App;
