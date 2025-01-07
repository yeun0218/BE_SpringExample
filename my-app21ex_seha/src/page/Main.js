import {useSelector, useDispatch} from 'react-redux';
import {useState, useEffect} from 'react';
import { Link } from 'react-router-dom';

const Main = () => {
    
    return(
        <div>
            <Link to="/list">전체자료 출력</Link>&nbsp;
            <Link to="/add">운동정보 등록</Link>&nbsp;
            <Link to="/update">칼로리소모량 수정</Link>&nbsp;
        </div>
    );
}
export default Main;