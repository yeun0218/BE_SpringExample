import React, { useState, useEffect, useMemo } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "../App.css";
import axios from "axios";

const Jikwon = () => {
  const [jikwon, setJikwon] = useState([]);
  const [filteredJikwon, setFilteredJikwon] = useState([]);
  const [error, setError] = useState(null);
  const [isLoaded, setIsLoaded] = useState(false);
  const [searchBuser, setSearchBuser] = useState("");

  useEffect(() => {
    axios("/list", { method: "GET" })
      .then((res) => {
        setJikwon(res.data);
        setFilteredJikwon(res.data);
        setIsLoaded(true);
      })
      .catch((error) => {
        setIsLoaded(true);
        setError(error);
      });
  }, []);

  const filterJikwon = () => {
    const filtered = jikwon.filter((j) =>
      j.busername.toLowerCase().includes(searchBuser.toLowerCase())
    );
    setFilteredJikwon(filtered);
  };

  const avgsal = useMemo(() => {
    return (
      filteredJikwon.reduce((sum, j) => sum + j.jikwonpay, 0) /
      filteredJikwon.length
    );
  }, [filteredJikwon]);

  if (!isLoaded) {
    return <div>로딩중 . . .</div>;
  } else if (error) {
    return <div>Error : {error}</div>;
  } else {
    return (
      <>
        <h2>직원 자료</h2>
        부서명 :{" "}
        <input
          type="text"
          value={searchBuser}
          onChange={(e) => setSearchBuser(e.target.value)}
        />
        <button onClick={filterJikwon}>확인</button>
        <div className="container">
          <div class="card">
            <table className="table">
              <thead>
                <tr>
                  <th scope="col">사번</th>
                  <th scope="col">이름</th>
                  <th scope="col">부서명</th>
                  <th scope="col">직급</th>
                  <th scope="col">연봉</th>
                </tr>
              </thead>
              <tbody>
                {filteredJikwon.map((j) => (
                  <tr key={j.jikwonno}>
                    <th scope="row">{j.jikwonno}</th>
                    <td>{j.jikwonname}</td>
                    <td>{j.busername}</td>
                    <td>{j.jikwonjik}</td>
                    <td>{j.jikwonpay}만원</td>
                  </tr>
                ))}

                <tr>
                  <td colSpan={2}>총인원 : {filteredJikwon.length}명</td>
                  <td colSpan={3}>평균 연봉 : {avgsal.toFixed(0)}만원</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </>
    );
  }
};

export default Jikwon;
