/**
 * AJAX로 데이터 조회, 변경 등의 작업을 한 후, 
 * 가져온 데이터를 토대로 화면에 구성하는 함수.
 * 
 * @param {Object} request 
 * @param {Function} showCallback - 가져온 데이터를 화면에 구성하는 콜백 함수
 * @param {Function} errorCallback - 에러 발생 시 처리할 콜백 함수.
 */
export function fetchAndShow(request, showCallback, errorCallback) {
    fetch(request.uri, request.options)
    .then(response => {
        if (!response.ok) {
            throw new Error("Http status Not Ok");
        }
        return response.json();
    })
    .then(data => {
        showCallback(data);
    })
    .catch(error => {
        let errorMsg = "에러 발생! : " + error;
        errorCallback(errorMsg);
    })
}