import axios from "axios";
import { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { Navigate, useNavigate } from "react-router-dom";
import { SET_CAL } from "../redux/ResourceSlice";

const Update = () => {
    const [num, setNum] = useState();
    const [data, setData] = useState({});
    const calorie = useSelector((state)=>state.calorie);

    const dispatch = useDispatch();
    const navigate = useNavigate();

    useEffect(() => {
        dispatch(SET_CAL(data.duration))
    },[data])

    const handleChange = (e) => {
        setData({ ...data, [e.target.id]:e.target.value});
    }

    const handleClick = () => {
        axios.get('/exercise/'+num)
        .then(res => {
            setData(res.data);
        })
        .catch(err => console.log(err));
    }

    const sendData = () => {
        const sendData = {...data, "calorieburn":calorie}

        axios.put('/exercise/'+num, sendData)
        .then(res => {
            if(res.data.isSuccess){
                navigate("/list")
            }
        })
        .catch(err => console.log(err));
    }

    return (
        <div>
            id : <input type="num" id="id" onChange={(e)=>{setNum(e.target.value)}} /> 
            <button onClick={handleClick}>수정 자료 읽기</button><br/>
            종목명 : <input type="text" id="name" value={data.name} onChange={handleChange}/><br/>
            운동시간 : <input type="text" id="duration" value={data.duration} onChange={handleChange}/><br/>
            <button onClick={sendData}>수정 확인</button>
        </div>
    );
}

export default Update;