let createDialog = () => {
    /* 상품 등록 dialog 창 생성 및 추가 */
    let insertDialog = document.createElement('dialog');
    insertDialog.setAttribute("id", "insertDialog");
    document.querySelector("body").appendChild(insertDialog);
    
    /* 상품 수정 dialog 창 생성 및 추가 */
    let updateDialog = document.createElement('dialog');
    updateDialog.setAttribute("id", "updateDialog");
    document.querySelector("body").appendChild(updateDialog);
    
    /* 상품 삭제 dialog 창 생성 및 추가 */
    let deleteDialog = document.createElement('dialog');
    deleteDialog.setAttribute("id", "deleteDialog");
    document.querySelector("body").appendChild(deleteDialog);
}
