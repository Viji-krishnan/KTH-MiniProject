import React, { Component } from 'react';
import 'font-awesome/css/font-awesome.min.css';



class HomePage extends Component {
  render() {
    return (
      
      <div className='card'>
       
        <div className='card-body'>
          <h4 className='card-title'>What is your dream vacation place?</h4>
          <p>
            Are you tired from staying at home? Let us have a discussion about
            the ideal vacation places! <i className='fa fa-globe'></i>
          </p>
        </div>
      </div>
    );
  }
}

export default HomePage;
