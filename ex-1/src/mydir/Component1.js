/*
function Component1(props){
    return(
        <div>
            미터 : {props.meter} / 센티미터 : {props.meter*100}
        </div>
    );
}
*/
import {Component} from 'react';
class Component1 extends Component{

    render(){
        return(
            <div>
            미터 : {this.props.meter} / 센티미터 : {this.props.meter*100}
        </div>
        );
    }
}

export default Component1;