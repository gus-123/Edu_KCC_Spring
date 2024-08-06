<%@ page contentType="text/html;charset=UTF-8" language="java" %>`

<!DOCTYPE html>
<html>
<head>
    <title>글 수정</title>
</head>
<body>
    <h3>게시글 수정</h3>
    <form action="board_update" method="post">
        <input type="hidden" name="seq" value="${update.seq }">
        <table>
            <tr>
                <th>글번호</th>
                <td>${update.seq }</td>
            </tr>
            <tr>
                <th>제목</th>
                <td><input type="text" name="title" value="${update.title }"></td>
            </tr>
            <tr>
                <th>작성자</th>
                <td>${update.writer }</td>
            </tr>
            <tr>
                <th>내용</th>
                <td><textarea rows="6" cols="70" name="contents">${update.contents }</textarea></td>
            </tr>
            <tr>
                <th>작성일</th>
                <td>${update.regdate }</td>
            </tr>
            <tr>
                <th>조회수</th>
                <td>${update.hitcount }</td>
            </tr>
        </table>
        <input type="submit" value="수정완료">
    </form>
</body>
</html>
