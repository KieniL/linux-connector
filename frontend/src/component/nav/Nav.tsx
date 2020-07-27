import React from 'react';
import './Nav.css';
import { Link } from "react-router-dom";

class Nav extends React.Component {

    navLinkCondition = false;
    navCondition = false;


    hamburgerClick = () => {
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
            <nav>
                <div className="hamburger" onClick={() => this.hamburgerClick()}>
                    <div className="line"></div>
                    <div className="line"></div>
                    <div className="line"></div>
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
            </nav>
            
        );
    }
}




export default Nav;