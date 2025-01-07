import { useDispatch, useSelector } from "react-redux"
import {UPDATE_QUANTITY, REMOVE_FROM_CART} from "../redux/ResourceSlice";
import {useState} from 'react';
import ToastExample from "./ToastExample";
const Cart = () => {

    //리덕스 디스패치
    const dispatch = useDispatch();

    //부트스트랩 토스트 토글용
    const [showA, setShowA] = useState(false);
    const toggleShowA = () => {
        setShowA(true)
        setTimeout(() => setShowA(false), 2000)
    }

    //Select 박스를 사용하기 위한 컴포넌트
    const Select = ({ quantity, id }) => {
        //Select 박스에 들어갈 옵션 태그 배열
        const options = [];
        //select 박스에 1~99까지의 숫자를 넣어줌
        for (let i = 1; i <= 99; i++) {
            options.push(<option key={i} value={i}>{i} 개</option>);
        }

        //수량 변경시 실행되는 함수
        const handleChange = (e) => {
            const newQuantity = parseInt(e.target.value);
            dispatch(UPDATE_QUANTITY({ id, quantity: newQuantity }));
        };

        return (
            <select value={quantity} onChange={handleChange}>
                {options}
            </select>
        );
    }

    const removeItem = (id) => {
        toggleShowA();
        dispatch(REMOVE_FROM_CART({id:id}));
    }

    const cart = useSelector(state => state.cart.items);
    const totalPrice = useSelector(state => state.cart.totalPrice);
    return(
        <div>
             <ToastExample toggleShowA={toggleShowA} showA={showA} type="delete"/>
            <br/><h2>장바구니</h2><br/>
            <table>
            <tr className="table-title">
                <th>제품명</th>
                <th>수량</th>
                <th>가격</th>
                <th>삭제</th>
            </tr>
            {cart.map(item => (
                <tr key={item.id}>
                    <td>{item.name}</td>
                    {/* <td><input type="number" value={item.quantity}/></td> */}
                    <td><Select quantity={item.quantity} id={item.id}/></td>
                    <td>{item.price * item.quantity} 원</td>
                    <td><span className="btn" onClick={() => removeItem(item.id)}>✖️</span></td>
                </tr>
            ))} 
            <tr className='space'>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td colSpan="4" className="result total-price"><b>총 액 : {totalPrice} 원</b></td> 
            </tr>
            
            </table>
        </div>
    )
}

export default Cart;