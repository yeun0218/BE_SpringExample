import React from "react";
import "../mycss/VisitItem.css"

function VisitItem({ visit, onDelete }) {
  return (
    <tr>
      <td>{visit.clientName}</td>
      <td>{visit.address}</td>
      <td>{visit.visitDate}</td>
      <td>
        <button onClick={() => onDelete(visit.id)}>삭제</button>
      </td>
    </tr>
  );
}

export default VisitItem;
