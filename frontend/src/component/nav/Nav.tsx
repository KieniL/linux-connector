import React from 'react';
import './Nav.css';
import { Link } from "react-router-dom";

import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';
/*import Button from 'react-bootstrap/Button';
import NavDropdown from 'react-bootstrap/NavDropdown';
import Form from 'react-bootstrap/Form';*/
//import FormControl from 'react-bootstrap/FormControl';

import 'bootstrap/dist/css/bootstrap.min.css';

class Navigation extends React.Component {

    navLinkCondition = false;
    navCondition = false;
    
    hamburgerClick () {
        if(this.navCondition){
            this.navCondition = false;
        }else{
            this.navCondition = true;
        }

        if(this.navLinkCondition){
            this.navLinkCondition = false;
        }else{
            this.navLinkCondition = true;
        }
    
      }

    
      
    render() {
        return  (
            <Navbar bg="light" expand="lg" fixed="top">
                <Link to="/">
                    <Navbar.Brand >Home</Navbar.Brand>                           
                </Link>               
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="mr-auto">
                            <Link to="/about">
                                <Nav.Link href="#pricing">About</Nav.Link>                            
                            </Link>
                            <Link to="/contact">
                                <Nav.Link href="#pricing">Contact</Nav.Link>                            
                            </Link>
                            <Link to="/projects">
                                <Nav.Link href="#pricing">Projects</Nav.Link>                            
                            </Link>  
                    </Nav>
                </Navbar.Collapse>
                </Navbar>
                /*<Nav.Link href="#home">Home</Nav.Link>
                        <Nav.Link href="#link">Link</Nav.Link>
                        <NavDropdown title="Dropdown" id="basic-nav-dropdown">
                            <Link to="/about">
                                <li className={this.navLinkCondition ? "toggle" : ""}>About</li>
                            </Link>
                            <NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
                            <NavDropdown.Item href="#action/3.2">Another action</NavDropdown.Item>
                            <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
                            <NavDropdown.Divider />
                            <NavDropdown.Item href="#action/3.4">Separated link</NavDropdown.Item>
                        </NavDropdown>*/
            /*<nav>
                <div className={this.navCondition ? "hamburger hamburger-click" : "hamburger"} onClick={() => {this.hamburgerClick()}} >
                    <div className="line bar1"></div>
                    <div className="line bar2"></div>
                    <div className="line bar3"></div>
                </div>
                
                <ul className={this.navCondition ? "nav_links open" : "nav_links"}>
                    <Link to="/about">
                        <li className={this.navLinkCondition ? "toggle" : ""}>About</li>
                    </Link>
                    <Link to="/contact">
                        <li className={this.navLinkCondition ? "toggle" : ""}>Contact</li>
                    </Link> 
                    <Link to="/projects">
                        <li className={this.navLinkCondition ? "toggle" : ""}>Projects</li>
                    </Link>
                    
                </ul>
            </nav>*/
            
        );
        
    }
}




export default Navigation;