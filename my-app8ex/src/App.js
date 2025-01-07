import { useState } from "react";
import ShowResult from "./mydir/ShowResult";
import './App.css';

function App() {
    const [code, setCode] = useState("");
    const [name, setName] = useState("");
    const [price, setPrice] = useState("");
    const [showResults, setShowResults] = useState(false);
    const [items, setItems] = useState([]);

    function handleRegister() {
        if (code && name && price) {
            const newItem = { code, name, price };
            setItems([...items, newItem]);
            alert("등록 완료!");
        } else {
            alert("값을 입력해주세요.");
        }
    }

    function handleDelete() {
        if (items.length > 0) {
            setItems(items.slice(0, items.length - 1));
            alert("마지막 항목이 삭제되었습니다.");
        } else {
            alert("삭제할 항목이 없습니다.");
        }
    }

    return (
        <div className="App">
            코드: <input type="number" value={code} onChange={(e) => setCode(e.target.value)} /><br/><br/>
            상품명: <input type="text" value={name} onChange={(e) => setName(e.target.value)} /><br/><br/>
            가격: <input type="number" value={price} onChange={(e) => setPrice(e.target.value)} /><br/><br/>

            <button type="button" onClick={handleRegister}>등록</button>
            <button type="button" onClick={handleDelete}>삭제</button>

            <button type="button" onClick={() => setShowResults(true)}>결과보기</button>

            <ShowResult items={items} showResults={showResults} />
        </div>
    );
}

export default App;
