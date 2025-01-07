import React, { useState, useCallback } from "react";
import VisitListTemplate from "./mydir/VisitListTemplate";
import Form from "./mydir/Form";
import VisitItemList from "./mydir/VisitItemList";

function App() {
  const [formData, setFormData] = useState({ clientName: "", address: "", visitDate: "" });
  const [visits, setVisits] = useState([]);
  const [nextId, setNextId] = useState(0);

  // 새로운 거래처 방문 기록 추가
  const addVisit = useCallback(() => {
    if (formData.clientName.trim() === "" || formData.address.trim() === "" || formData.visitDate.trim() === "") {
      alert("이름, 주소, 방문일을 모두 입력해주세요.");
      return;
    }

    setVisits((prevVisits) => 
      prevVisits.concat({
        id: nextId,
        clientName: formData.clientName,
        address: formData.address,
        visitDate: formData.visitDate,
      })
    );
    
    setFormData({ clientName: "", address: "", visitDate: "" });
    setNextId((prevId) => prevId + 1);
}, [formData, nextId]);

  // 특정 방문 기록 삭제
  const deleteVisit = useCallback((id) => {
    setVisits((prevVisits) => prevVisits.filter((visit) => visit.id !== id));
  }, []);

  // 모든 방문 기록 초기화
  const clearVisits = useCallback(() => {
    setVisits([]);
  }, []);

  const handleChange = useCallback((e) => {
    const { name, value } = e.target;
    setFormData((data) => ({ ...data, [name]:value }));
  }, []);

  return (
    <VisitListTemplate
      form={
        <Form
          formData={formData}
          onChange={handleChange}
          onAdd={addVisit}
        />
      }
    >
      <VisitItemList
        visits={visits}
        onDelete={deleteVisit}
      />
      <button className="clear-button" onClick={clearVisits}>
        전체 삭제
      </button>
    </VisitListTemplate>
  );
}

export default App;
