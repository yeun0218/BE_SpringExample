import React from "react";
import VisitItem from "./VisitItem";

function VisitItemList({ visits, onDelete }) {
  return (
    <table>
      <thead>
        <tr>
          <th>거래처 이름</th>
          <th>주소</th>
          <th>방문일</th>
          <th>삭제</th>
        </tr>
      </thead>
      <tbody>
        {visits.map((visit) => (
          <VisitItem key={visit.id} visit={visit} onDelete={onDelete} />
        ))}
      </tbody>
    </table>
  );
}

export default VisitItemList;
