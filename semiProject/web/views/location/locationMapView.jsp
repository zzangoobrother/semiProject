<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b07804eb6c910b861023a656cfa85814&libraries=services"></script>


<div>
	<!-- 검색구역 -->
	<div align="center">
		<select>
			<option>강남구</option>
			<option>강동구</option>
			<option>강북구</option>
			<option>강서구</option>
			<option>관악구</option>
			<option>광진구</option>
			<option>구로구</option>
			<option>금천구</option>
			<option>노원구</option>
			<option>도봉구</option>
			<option>동대문구</option>
			<option>동작구</option>
			<option>마포구</option>
			<option>서대문구</option>
			<option>서초구</option>
			<option>성동구</option>
			<option>성북구</option>
			<option>송파구</option>
			<option>양천구</option>
			<option>영등포구</option>
			<option>용산구</option>
			<option>은평구</option>
			<option>종로구</option>
			<option>중구</option>
			<option>중랑구</option>
		</select>
		<input type="search" placeholder="주소 또는 주민센터">
		<button onclick="addressSelect();">검색</button>
	</div>
	
	<!-- 지도 출력 -->
	<div id="map" align="center" style="width:100%;height:350px;"></div>
	
	<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new daum.maps.Map(mapContainer, mapOption); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new daum.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
function addressSelect() {
	var address = document.getElementById("address").value;
	console.log(address);
	geocoder.addressSearch(address, function(result, status) {

	    // 정상적으로 검색이 완료됐으면 
	     if (status === daum.maps.services.Status.OK) {

	        var coords = new daum.maps.LatLng(result[0].y, result[0].x);

	        // 결과값으로 받은 위치를 마커로 표시합니다
	        var marker = new daum.maps.Marker({
	            map: map,
	            position: coords
	        });

	        // 인포윈도우로 장소에 대한 설명을 표시합니다
	        var infowindow = new daum.maps.InfoWindow({
	            content: '<div style="width:150px;text-align:center;padding:6px 0;">우리회사</div>'
	        });
	        infowindow.open(map, marker);

	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        map.setCenter(coords);
	    } 
	});
}
</script>

	<!-- 주소 리스트 -->
	<div align="center">
		<table cellspacing="0" border="1">
			<tr>
				<th>상세주소</th><th>주민센터</th>
			</tr>
			<tr>
				<td>강남구1</td><td>주민센터1</td>
			</tr>
		</table>
	</div>
</div>
<%@ include file="../../footer.jsp" %>