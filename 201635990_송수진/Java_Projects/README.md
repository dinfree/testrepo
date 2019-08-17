## DogCamper ##
### 애견 캠핑장을 유저가 예약하는 시스템##


####제한조건 - User(프로젝트상에서 Camper)가 등록한 DogType을 이용해 사용가능한 캠핑장 제한.
            - 캠핑장에 validCamp를 부여해 이용가능한 사용자 수 제한
            
####주요함수 - in CampSite.java :: countRoom() - validCamp를 체크하고 예약가능/불가능 메시지 출력후 가능한 경우 해당 캠프의 validCamp 감소.
                                  record() - CampSite 객체를 생성할 때 마다 캠프 별 예약리스트 텍스트파일 생성
              in DogCamper.java :: start() - 생성된 campers 배열 중 계정선택
                                   campList() - 생성된 campingSites 배열 중 캠핑장 선택 및 [b]를 입력해 "찜하기" 기능 실행
                                   book() - campList()에서 선택된 캠핑장 출력 및 "예약하기" 기능 실행. "예약하기"기능 실행시 선택된 캠핑장
                                   별로 DogType과 countRoom()을 이용해 예약을 실행하고, 예약이 성공한 경우 예약리스트 텍스트 파일에 
                                   해당 결과를 입력
                                   
