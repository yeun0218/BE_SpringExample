import React from "react";
import "../mycss/VisitListTemplate.css";

function VisitListTemplate({ form, children }) {
  return (
    <main className="visitListTemplate">
      <h1>거래처 정보 입력</h1>
      <div className="form">
        {form}
      </div>
      
      <div className="children">
        {children}
      </div>
    </main>
  );
}

export default VisitListTemplate;
