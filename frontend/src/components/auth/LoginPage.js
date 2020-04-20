import React, { Component } from "react";
import LoginForm from "./LoginForm";
import RegisterForm from "./RegisterForm";
import Auth from "../../services/Auth";
import Logo from '../../img/logo.png'

class LoginPage extends Component {
    async login(loginData) {
        const loginSuccess = await Auth.login(loginData);
        if (!loginSuccess) {
            alert("Invalid credentials");
        }
    }

    async register(registrationData) {
        const registerSuccess = await Auth.register(registrationData);
        if (!registerSuccess) {
            alert("Couldn't register check credentials and try again");
        }
    }

    render() {
        return (
          <div className='wrapper'>
            <div className='container'>
              <img src={Logo} id='logo' />
              <div className='row mt-4'>
                <div className='col-md-6 ' style={{ color: 'white' }}>
                  <h1>Dream Vacation Place Forum</h1>
                  <p>
                    Do you want to find a friend who has the same interest in
                    travelling? Sign up!
                  </p>
                </div>

                <div className='col-md-6'>
                  <div className='row'>
                    <div className='col-12  strong-shadow'>
                      <LoginForm onSubmit={this.login} />
                    </div>

                    <div className='col-12 mt-4'>
                      <RegisterForm onSubmit={this.register} />
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        );
    }
}

export default LoginPage;