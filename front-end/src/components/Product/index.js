import React from 'react';

import '../../global.css';
import './styles.css';

function Product(params){
  return(
      <div id="product">
        <h2 className="nomeDoProduto">#{params.id} - Vaso de cimento</h2>
        <div className="containerPreco">
          <span className="precoDoProdutoVenda">R$ 17,00</span>
          <button className="remover">
            <p>x</p>
          </button>
        </div>
        
      </div>
);
};

export default Product;