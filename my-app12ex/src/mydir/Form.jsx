import React from "react";
import "../mycss/Form.css"

function Form({ formData, onChange, onAdd }) {
  const handleKeyDown = (e) => {
    if (e.key === "Enter") {
      onAdd();
    }
  };

  return (
    <div className="form">
      <div>
        <label>거래처 이름 </label>
        <input
          type="text"
          name="clientName"
          value={formData.clientName}
          onChange={onChange}
        />
      </div>
      
      <div>
        <label>주소 </label>
        <input
          type="text"
          name="address"
          value={formData.address}
          onChange={onChange}
        />
      </div>
      
      <div>
        <label>방문일 </label>
        <input
          type="date"
          name="visitDate"
          value={formData.visitDate}
          onChange={onChange}
          onKeyDown={handleKeyDown}
        />
      </div>
      <button onClick={onAdd}>등록</button>
    </div>
  );
}

export default Form;
