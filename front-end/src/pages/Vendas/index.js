import React from 'react';
import Footer from '../../components/Footer';
import Header from '../../components/Header';
import '../../global.css';

function Vendas() {
  return (
    <>
      <Header menu={true}/>
      <div id="container">
        <div className="card">
          <h1>vendas</h1>
        </div>
      </div>
      <Footer />
    </>
  );
}
export default Vendas;
