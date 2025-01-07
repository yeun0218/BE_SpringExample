import {useDispatch} from 'react-redux';
import { ADD_TO_CART } from '../redux/ResourceSlice';
import ToastExample from './ToastExample';
import {useState} from 'react';


const ProductList = () => {
    //리덕스 디스패치
    const dispatch = useDispatch();

    //부트스트랩 토스트 토글용
    const [showA, setShowA] = useState(false);
    const toggleShowA = () => {
        setShowA(!showA)
        setTimeout(() => {
        setShowA(false)
        }, 3000)
    }

    //제품 리스트 기본값 설정
    const products = [
    { id: 1, name: "마우스", price: 5000 },
    { id: 2, name: "키보드", price: 50000 },
    { id: 3, name: "모니터", price: 500000 },
];

    //장바구니에 제품 추가
    const addCart = prod => {
        toggleShowA(); //토스트 메시지 토글
        dispatch(ADD_TO_CART({id: prod.id, name: prod.name, price: prod.price, quantity: 1}));
        
    }

    return(
        <div>
            <ToastExample toggleShowA={toggleShowA} showA={showA} type="add"/>
            <br/><h2>제품 리스트</h2><br/>
            <table>
                <tr className="table-title">
                    <th>제품 번호</th>
                    <th>제품 명</th>
                    <th>제품 가격</th>
                    <th>장바구니에 추가</th>
                </tr>
                {products.map(prod => (
                    <tr key={prod.id}>
                        <td>{prod.id}</td>
                        <td>{prod.name}</td>
                        <td>{prod.price}</td>
                        <td><button className="btn btn-primary" onClick={() => addCart(prod)}>추가</button></td>
                    </tr>
                ))}
            </table>
        </div>
    )
}
export default ProductList;