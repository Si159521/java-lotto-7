package lotto;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;

import static java.lang.Integer.parseInt;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        for(int i=0;i<numbers.size();i++){
            if(numbers.get(i)<1 || numbers.get(i)>45){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45의 숫자여야 합니다.");
            }
        }
        for(int i=1;i<numbers.size()-1;i++){
            if(numbers.get(i)==numbers.get(i+1)){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 불가능합니다.");
            }
        }
    }

    // TODO: 추가 기능 구현
    public void main() {
        //입력받기
        System.out.println("구입금액을 입력해 주세요.");
        int tickets = 0;
        try {
            int price = parseInt(Console.readLine());
            if (price <= 0 || price % 1000 != 0) {
                throw new IllegalArgumentException();
            }
            tickets = price / 1000;
        } catch (IllegalArgumentException e) {
            System.out.println("[Error] 구입 금액은 1,000원 단위로 입력되어야 합니다.");
        }

        //로또발행
        MakeTickets makeTickets = new MakeTickets(tickets);
        List<List<Integer>> randomTickets = makeTickets.getTickets();

        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        for (String num : input.split(",")) {
            numbers.add(Integer.parseInt(num.trim()));
        }
        new Lotto(numbers);
        //예외처리 클라스로 Lotto를 호출하는 게 나을까 아님 validate메소드를 호출하는 게 나을까

        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            int bonusNum = parseInt(Console.readLine());
            if(bonusNum<1 || bonusNum>45){
                throw new IllegalArgumentException();
            }
        }catch(IllegalArgumentException e){
            System.out.println("보너스번호는 1~45의 정수 입니다.");
        }

        //출력하기
        System.out.println(tickets+"개를 구매했습니다.");
        System.out.println(randomTickets);

    }



}