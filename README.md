# java-lotto-precourse
## 구현할 기능 목록
### 입력 역할
- [x] 구입 금액을 입력받는 기능
- [x] 당첨 번호를 입력받는 기능
- [x] 보너스 번호를 입력받는 기능

### 출력 역할
- [ ] 발행한 로또 수량 및 번호(오름차순)를 출력하는 기능
- [ ] 당첨 내역을 출력하는 기능
- [ ] 소수점 둘째 자리에서 반올림한 수익률을 출력하는 기능
- [ ] 오류를 출력하는 기능

### 파싱 역할
- [ ] 입력 값을 객체로 파싱하는 역할  
특이사항: 입력값이 잘못되면 재입력 요청을 해야하기 때문에, Service에서 분기를 관리하는 게 좋겠다.

### 돈 역할(UserMoney)
- [ ] currentMoney, usedMoney, earnedMoney를 필드로 가지고 있다.
- [ ] 티켓을 구매할 수 있는 기능(티켓을 반환하고 money를 그만큼 감소시킨 후, usedMoney에 업데이트)
- [ ] 수익률을 반환하는 기능

### 로또 번호 역할(Lotto)
- [ ] 로또 번호 6자리를 필드로 가지고 있다.
- [ ] 로또 번호에 대한 검증이 필요하다.
- [ ] 랜덤 번호를 가진 객체를 생성할 수 있는 정적 팩토리 메서드

### 당첨 로또 번호 역할
- [ ] 당첨 로또 번호 6자리와 보너스 번호를 필드로 가지고 있다.
- [ ] 로또 번호가 주어지면 당첨 여부를 반환하는 기능

### 로또 순위 정보 Enum
- [ ] 로또 순위 정보를 포함한다.
- [ ] 객체간 데이터를 전달하는데에 쓰인다.

<br>

## 변경된 구현 사항
.. 아직 없음