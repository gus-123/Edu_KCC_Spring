<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>글 상세</title>
</head>
<body>
    <h3>글세부보기</h3>
    <table border="1">
        <tr>
            <th>글번호</th>
            <td>${detail.seq }</td>
        </tr>
        <tr>
            <th>제목</th>
            <td>${detail.title}</td>
        </tr>
        <tr>
            <th>작성자</th>
            <td>${detail.writer }</td>
        </tr>
        <tr>
            <th>내용</th>
            <td><pre>${detail.contents }</pre></td>
        </tr>
        <tr>
            <th>작성일</th>
            <td>${detail.regdate }</td>
        </tr>
        <tr>
            <th>조회수</th>
            <td>${detail.hitcount }</td>
        </tr>
        <tr>
        	<th>삭제</th>
        	<td>
        		<form action="board_delete?seq=${detail.seq }" method="post">
					<input type="submit" value="삭제">
				</form>
			</td>
        </tr>
    </table>
    <br>
    <a href="board_update?seq=${detail.seq }">수정</a>
    <a href="board_list">목록으로</a>
</body>
</html>
