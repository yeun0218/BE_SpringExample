import axios from "axios";
import { useState } from "react";

const List = () => {
    
    const [column, setColumn] = useState({
        name:false, duration:false, calorieburn:false
    });
    const [dataList, setDataList] = useState([]);

    const handleClick = (e) => {
        setColumn({...column, [e.target.id]:e.target.checked});
    }

    const showData = () => {
        setDataList([]);
        axios.get('/exercise')
        .then(res => {
            res.data.forEach((item)=>{
                setDataList((pre)=>
                    [...pre, item]
                )
            })
            console.log(dataList);
        })
        .catch(err => console.log(err));
    }

    return (
        <table>
            <thead>
            <tr>
                <th>ID</th>&nbsp;&nbsp;
                <th>운동명
                    <input type="checkbox" id="name" onClick={handleClick}/>
                </th>
                <th>운동시간
                    <input type="checkbox" id="duration" onClick={handleClick}/>
                </th>
                <th>소모칼로리
                    <input type="checkbox" id="calorieburn" onClick={handleClick}/>
                </th>
                <th>
                    <button onClick={showData}>확인</button>
                </th>
            </tr>
            </thead>
            <tbody>
            {dataList.map((data)=>(
                <tr key={data.id}>
                    <td>{data.id}</td>&nbsp;
                    {column.name ? <td>{data.name}</td> : <td></td>}
                    {column.duration ? <td>{data.duration}</td>: <td></td>}
                    {column.calorieburn ? <td>{data.calorieburn}</td>: <td></td>}
                </tr>
            ))}
            </tbody>
        </table>
    );
    
}
export default List;