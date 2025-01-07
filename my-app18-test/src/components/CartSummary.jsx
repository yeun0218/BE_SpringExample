import {useSelector} from 'react-redux';

const CartSummary = () => {
    const cart = useSelector(state => state.cart.items);
    const getTotalPrice = useSelector(state => state.cart.totalPrice);
    
    return (
        <div>
            <div></div>
            <br/><h2>결제진행</h2><br/>
            <table>
            <tr className="table-title">
                <th>제품명</th>
                <th>수량</th>
                <th>가격</th>
            </tr>
            {cart.map(item => (
                <tr key={item.id}>
                    <td>{item.name}</td>
                    {/* <td><input type="number" value={item.quantity}/></td> */}
                    <td>{item.quantity}</td>
                    <td>{item.price * item.quantity} 원</td>
                </tr>
            ))} 
            <tr className='space'>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td colSpan="2" className='result total-price'><b>총 액 : {getTotalPrice} 원</b></td> 
                <td className='result'><button className='btn btn-primary'>결제 진행</button></td>
            </tr>
            </table>
        </div>
    )
}
export default CartSummary;