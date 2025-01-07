import {Routes, Link, Route, BrowserRouter as Router} from 'react-router-dom';
import { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { SET_DATA } from './redux/ResourceSlice';
import Main from './page/Main';
import List from './page/List';
import Add from './page/Add';
import Update from './page/Update';

function App() {
  const [list, setList] = useState({});

  const weight = useSelector((state) => state.weight);
  const dispatch = useDispatch();

  const handleChange = (e) => {
    setList({ ...list, [e.target.id]:e.target.value});
  }
  
  useEffect(() => {
    dispatch(SET_DATA(list));
  },[list])

  return (
    <Router>
    <div className="App">
      <h3>메인</h3>
      사용자명 : <input type="text" id="name" onChange={handleChange}/> 
      체중 : <input type="number" id="num" onChange={handleChange}/>Kg<br/>
      <Link to="/exercise">운동 기록 정보 보기</Link>&nbsp;기타
      <Routes>
        <Route path="/exercise" element={<Main></Main>} />
        <Route path="/list" element={<List></List>} />
        <Route path="/add" element={<Add></Add>} />
        <Route path="/update" element={<Update></Update>} />
      </Routes>
    </div>
    </Router>
  );
}

export default App;
