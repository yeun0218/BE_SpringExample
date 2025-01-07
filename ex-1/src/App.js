import './App.css';
/*
import Component1 from './mydir/Component1';
import {useState} from 'react';
function App() {
  const [meter, setMeter] = useState(0);
  const numberHandler =()=>{
    let num = document.getElementById("num").value;
    setMeter(num);
  }
  return (
    <div className="App">
      <h3>길이 환산</h3>
      <input type="number" id='num'></input><button onClick={numberHandler}>계산</button>
      <Component1 meter={meter}></Component1>
    </div>
  );
}
*/
import {Component} from 'react';
import Component1 from './mydir/Component1';
class App extends Component{
  state = {meter:0}

  numberHandler =()=>{
    let num = document.getElementById("num").value;
    this.setState({meter:num});
  }
  render(){
    return(
      <div className='App'>
        <h3>길이 환산</h3>
        <input type="number" id='num'></input><button onClick={this.numberHandler}>계산</button>
        <Component1 meter={this.state.meter}></Component1>
      </div>
    );
  }
}
export default App;
