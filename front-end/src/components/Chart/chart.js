import React, {Component} from 'react';
import {Bar} from 'react-chartjs-2';

import './chart.css';

class Chart extends Component {

  constructor(props){
    super(props)
    this.state = {
      charData:{
        labels: [
          'janeiro', 'fevereiro', 'março', 'abril', 'maio', 'junho', 'julho', 'agosto'
        ],
        datasets:[
          {
            label:'Vendas/mês',
            fill: false,
            borderColor: 'blue',
            data: [
              200, 200, 250, 200, 250, 200, 200, 100
            ],
            backgroundColor:[
              'rgba(255, 99, 132, 0.6)',
              'rgba(255, 255, 132, 0.6)',
              'rgba(255, 200, 132, 0.6)',
              'rgba(255, 99, 200, 0.6)',
              'rgba(255, 100, 132, 0.6)',
              'rgba(255, 50, 132, 0.6)',
              'rgba(200, 99, 132, 0.6)',
              'rgba(100, 99, 132, 0.6)',
            ]
          }
        ]
      }
      
    }
  }

  render(){
    return (
      <div className="chart">
        <Bar
          data={this.state.charData}
          options={{
            maintainAspectRatio: true
          }}
        />
      </div>
    )
  }
}

export default Chart;
