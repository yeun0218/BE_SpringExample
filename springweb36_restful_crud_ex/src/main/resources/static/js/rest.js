/* 상품 목록 조회 : GET */
const selectData = () => {
    // dialog 태그 생성
    createDialog();

    // Resource (sangdata), Verb (get 조회), Representation (sangdata의 모든 레코드 조회)
    let url = `/api/sang`;
    let options = {method: "GET"}; 
    fetchProcess(url, options, selectThen);
}

/* GET 요청 fetchProcess 콜백함수 */
const selectThen = (list) => {
    const tbody = document.querySelector("#tableBody");
    tbody.innerHTML = "";
    list.forEach(sang => {
        let row = document.createElement('tr');
        row.innerHTML = `
            <td>${sang.code}</td>
            <td>${sang.sang}</td>
            <td>${sang.su}</td>
            <td>${sang.dan}</td>
            <td>
                <a href="#" onclick="updateData(${sang.code})">수정</a>
            </td>
            <td>
                <a href="#" onclick="deleteData(${sang.code})">삭제</a>
            </td>`;
        tbody.appendChild(row);
    });
    let tr = document.createElement('tr');
    tr.innerHTML = `<td colspan="4">상품 종류 : ${list.length}개</td>
                    <td colspan="2"><button id="btnInsert" type="button">상품 추가</button></td>`;
    tbody.appendChild(tr);
    // 등록 이벤트 발생
    document.querySelector("#btnInsert").addEventListener("click", insertData);
}

/* 데이터 추가 : POST */
const insertData = () => {
    // dialog 창 생성
    const insertDialog = document.querySelector("#insertDialog");
    let str = 
        `<h2>상품 추가</h2>
            품번 : <input type="number" name="code"> <br>
            품명 : <input type="text" name="sang"> <br>
            수량 : <input type="number" name="su"> <br>
            단가 : <input type="number" name="dan"> <br>
            <button id="closeInsert" type="button"> 추 가 </button> <button class="quit" type="button"> 취 소 </button>`;
    insertDialog.innerHTML = str;
    /* 등록 창 띄우기 */
    insertDialog.showModal();
    
    // 추가 버튼 클릭 이벤트
    document.querySelector("#closeInsert").addEventListener("click", () => {
        // DOM 접근
        const code = document.querySelector("#insertDialog input[name=code]").value;
        const sang = document.querySelector("#insertDialog input[name=sang]").value;
        const su = document.querySelector("#insertDialog input[name=su]").value;
        const dan = document.querySelector("#insertDialog input[name=dan]").value;

        // 추가 요청
        // Resource (sangdata), Verb (post 추가), Representation (request body에 해당하는 데이터 추가)
        let url = "/api/sang";
        let options = { 
            method: "post", 
            headers: {
                // 컨트롤러에서 @RequestBody로 수신한다.
                "Content-Type":"application/json"
            },
            body: JSON.stringify({ // "큰따옴표"로 묶지 않아도 (되긴) 된다.
                code: code,
                sang: sang,
                su: su,
                dan: dan
            })
        };
        /* fetch 처리 로직 함수 호출 */
        fetchProcess(url, options, successProcess);
        // 등록창 종료
        insertDialog.close();
    });

    // 취소 버튼 클릭 시 그냥 종료
    document.querySelector("#insertDialog .quit").addEventListener("click", () => {
        insertDialog.close();
    })
}


/* 상품 수정 : PUT */
const updateData = (code) => {
    // 수정 창 DOM 접근
    const updateDialog = document.querySelector("#updateDialog");
    
    // 정보 수정 창 데이터 조회 : get
    // Resource (sangdata), Verb (get 조회), Representation (상품 코드가 변수 code의 데이터와 일치하는 레코드)
    let url = `/api/sang/${code}`;
    let options = {method:"GET"}; 
    fetchProcess(url, options, updateThen);

    // 수정창 띄우기
    updateDialog.showModal();
}

/* PUT 요청 fetchProcess 콜백 함수 */
const updateProcess = () => {
    // DOM 접근
    const code = document.querySelector("#updateDialog input[name=code]").value;
    const sang = document.querySelector("#updateDialog input[name=sang]").value;
    const su = document.querySelector("#updateDialog input[name=su]").value;
    const dan = document.querySelector("#updateDialog input[name=dan]").value;

    // 수정 요청 : PUT
    let url = "/api/sang";
    let options = { 
        method: "put", 
        headers: {
            "Content-Type":"application/json"
        },
        body: JSON.stringify({
            "code":code,
            "sang":sang,
            "su":su,
            "dan":dan
        })
    };
    fetchProcess(url, options, successProcess);
}


/* 데이터 삭제 : DELETE */
const deleteData = (code) => {
    // 삭제 확인 및 모달 창 생성
    let deleteModal = document.querySelector("#deleteDialog");
    // 내용 입력
    let str = `
        <h2>삭제 확인</h2>
        <p>정말 삭제하시겠습니까</p>
        <button id="closeDelete" type="button"> 삭 제 </button> <button class="quit" type="button"> 취 소 </button>
    `;
    deleteModal.innerHTML = str;

    // 삭제 확인 창 띄우기
    deleteModal.showModal();

    // 삭제 버튼 클릭 시 이벤트 발생
    document.querySelector("#closeDelete").addEventListener("click", () => {
        /* 삭제 처리 함수 호출 */
        deleteProcess(code);
        // 창 닫기
        deleteModal.close();
    })

    // 취소 버튼 클릭 시 삭제 요청 없이 종료
    document.querySelector("#deleteDialog .quit").addEventListener("click", () => {
        deleteModal.close();
    })
}

/* 데이터 삭제 처리 함수 */
const deleteProcess = (code) => {
    // 삭제 요청 : DELETE
    let url = `/api/sang/${code}`;
    let options = {method: "delete"};
    fetchProcess(url, options, successProcess);
}

/* 오류 출력 함수 */
const showError = (error) => {
    document.querySelector("#error").textContent = error;
}


/* fetch 처리 함수 */
const fetchProcess = (url, options, callback) => {
    fetch(url, options)
    .then(response => {
        if(!response.ok) throw new Error("네트워크 오류");
        return response.json();
    })
    .then(data => {
        callback(data);
    })
    .catch(error => {
        showError(error);
    })
}

/* 성공 여부에 따른 메시지 반환 후 처리 (INSERT, UPDATE, DELETE) */
const successProcess = (data) => {
    if (data.isSuccess) {
        selectData();
    } else {
        showError(data.error);
    }
}

/* 호이스팅 지원이 되지 않아서 selectData 함수 선언 이후에 작성 */
// document.addEventListener('DOMContentLoaded',selectData);
