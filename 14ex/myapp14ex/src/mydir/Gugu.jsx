import React, { useState } from "react";

const Gugu = () => {
  const [gugunum, setGugunum] = useState("");
  const [result, setResult] = useState([]);

  const guguCal = (e) => {
    e.preventDefault();
    const num = parseInt(gugunum);

    const newResult = [];
    for (let i = 1; i <= 9; i++) {
      newResult.push(num * i);
    }
    setResult(newResult);
  };

  const handleChange = (e) => {
    const value = e.target.value;
    setGugunum(value);
    if (value === "") {
      setResult([]);
    }
  };

  return (
    <>
      <h2>구구단 99단</h2>
      <h3>숫자를 입력하세요</h3>
      <form onSubmit={guguCal}>
        <input
          type="number"
          id="gugunum"
          value={gugunum}
          onChange={handleChange}
        />
        <input type="submit" value="확인" />
      </form>
      <div className="container">
        <div className="card" style={{ width: "10rem" }}>
          <ul className="list">
            {result.map((item, index) => (
              <li key={index}>
                {gugunum} x {index + 1} = {item}
              </li>
            ))}
          </ul>
        </div>
      </div>
    </>
  );
};

export default Gugu;
