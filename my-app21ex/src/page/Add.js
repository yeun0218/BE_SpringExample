import { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { SET_CAL } from "../redux/ResourceSlice";
import axios from "axios";
import { useNavigate } from "react-router-dom";


const Add = () => {
    const weight = useSelector((state)=>state.weight);
    const calorie = useSelector((state)=>state.calorie);
    const dispatch = useDispatch();

    const [data, setData] = useState({});

    const handleChange = (e) =>{
        setData(
            {...data, [e.target.id]:e.target.value}
        )
    }

    useEffect(() => {
        dispatch(SET_CAL(data.duration))
    },[data])

    const navigate = useNavigate();


    const handleClick = () => {

        const sendData = {...data, "calorieburn":calorie}
        console.log(sendData);
        
        axios.post('/exercise', sendData)
        .then(res => {
            if(res.data.isSuccess){
                navigate("/list")
            }
        })
        .catch(err => console.log(err));
        
    }
    return(
        <div>
            운동명 : <input type="text" id="name" onChange={handleChange}/>&nbsp;운동시간 : <input type="text" id="duration" onChange={handleChange}/>
            &nbsp;&nbsp;<button onClick={handleClick}>등록</button>
        </div>
    );
}
export default Add;