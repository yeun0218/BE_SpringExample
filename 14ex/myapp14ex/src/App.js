import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";
import {
  Route,
  Switch,
  NavLink,
  Link,
  BrowserRouter as Router,
  Routes,
} from "react-router-dom";
import Gugu from "./mydir/Gugu.jsx";
import Jikwon from "./mydir/Jikwon.jsx";

function App() {
  return (
    <Router>
      <div className="App">
        <h2>라우팅 문제</h2>
        <hr />
        <nav>
          <Link to="/gugu">구구단</Link> |&nbsp;
          <Link to="/jikwon">직원 자료</Link> |&nbsp;
        </nav>
        <Routes>
          <Route path="/gugu" element={<Gugu />}></Route>
          <Route path="/jikwon" element={<Jikwon />}></Route>
        </Routes>
      </div>
    </Router>
  );
}

export default App;
