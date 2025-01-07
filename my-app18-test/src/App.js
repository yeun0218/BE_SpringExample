import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {useSelector} from "react-redux";
import ProductList from './components/ProductList';
import Cart from './components/Cart';
import CartSummary from './components/CartSummary';
import {Link, BrowserRouter as Router, Route, Routes} from 'react-router-dom';

//items, totalAmount:0, errorMsg
function App() {
  const items = useSelector(state => state.cart.items);
  console.log(items)
  return (
    <Router>
    <div className="App">
      <Link to="products">제품 리스트</Link> &nbsp;|&nbsp;
      <Link to="cart">장바구니</Link> &nbsp;|&nbsp;
      <Link to="payment">결제창</Link>
      <Routes>
        <Route path="products" element={<ProductList/>}/>
        <Route path="cart" element={<Cart/>}/>
        <Route path="payment" element={<CartSummary/>}/>
      </Routes>
    </div>
    </Router>
  );
}

export default App;
