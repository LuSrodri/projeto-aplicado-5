import React from 'react';
import { Link } from 'react-router-dom';
import './styles.css';

function Header(props) {
  
  if(props.menu){
    return (
      
      <header>
          <div className="margem">
            <span> <Link to="/home">ProjetoAplicado</Link></span>
            <ul className="menu">
              <li><Link to="/">sair</Link></li>
            </ul>
          </div>
      </header>
    );
  }else{
    return (
      <header>
          <div className="margem">
            <span> <Link to="/">ProjetoAplicado</Link></span>
          </div>
      </header>
    );
  }
  
}

export default Header;

