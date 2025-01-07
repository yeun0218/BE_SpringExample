import React from "react";

function ShowResult({ items, showResults }) {
    if (!showResults) return null;

    const totalCount = items.length;
    const totalPrice = items.reduce((sum, item) => sum + Number(item.price), 0);
    const averagePrice = totalCount > 0 ? totalPrice / totalCount : 0;

    return (
        <div>
            <h3>결과:</h3>
            <table border="1">
                <thead>
                <tr>
                    <th>코드</th>
                    <th>상품명</th>
                    <th>가격</th>
                </tr>
                </thead>
                <tbody>
                {items.map((item, index) => (
                    <tr key={index}>
                        <td>{item.code}</td>
                        <td>{item.name}</td>
                        <td>{item.price}</td>
                    </tr>
                ))}
                </tbody>
            </table>

            <div className="count">
                <p>건수</p>
                <p>{totalCount}건</p>
            </div>
            <div className="total">
                <p>가격 합계</p>
                <p>{totalPrice}원</p>
            </div>
            <div className="avg">
                <p>평균 가격</p>
                <p>{averagePrice}원</p>
            </div>
        </div>
    );
}

export default ShowResult;
