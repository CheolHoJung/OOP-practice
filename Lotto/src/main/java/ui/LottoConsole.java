package ui;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.InputMismatchException;
import java.util.Scanner;

import lotto.machine.LottoMachine;
import lotto.machine.LottoMachine.LottoStatistics;
import lotto.number.LottoNumber;
import lotto.ticket.LottoTicket;

public class LottoConsole {

    public static void main(String[] args) {
        Asker asker = new Asker(System.out);
        final int money = asker.askMoney();
        final int count = money / LottoTicket.MONEY_PER_TICKET;
        System.out.println(count + "장을 구매하셨습니다.");

        final LottoTicket[] lottos = new LottoTicket[count];
        
        for (int i = 0; i < count; i++) {
            lottos[i] = asker.askLottoNumbers(i + 1);
        }
        
        LottoMachine machine = new LottoMachine();
        machine.setWinNumberTicket(asker.askWinNumber());
        machine.setBonusNumber(asker.askBonusNumber());
        
        for (LottoTicket lotto : lottos) {
            machine.raffle(lotto);
        }
        
        LottoStatistics statistics = machine.statistics();
        System.out.println(statistics);
    }
    
    public static class Asker {
        InputStream in;
        
        Scanner sc;
        
        PrintStream out;
        
        public Asker(PrintStream out) {
           this(System.in, out);
        }
        
        public Asker(InputStream in, PrintStream out) {
            this.in = in;
            this.sc = new Scanner(in);
            this.out = out;
        }
        
        public int askMoney() {
            printlnWhenIsKeyBoard("구매금액을 입력해 주세요");
            
            if (!sc.hasNextInt()) {
                throw new InputMismatchException("구매금액은 숫자를 입력해야합니다.");
            }
            
            int input = sc.nextInt();
            if (sc.hasNextLine()) {
                sc.nextLine();
            }
            if (input % LottoTicket.MONEY_PER_TICKET != 0) {
                throw new IllegalStateException("구매금액은 " + LottoTicket.MONEY_PER_TICKET + "원 단위입니다");
            }
            return input;
        }
        
        private void printlnWhenIsKeyBoard(String msg) {
            if (isKeyboard()) {
                try {
                    out.write((msg + "\n").getBytes("UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private boolean isKeyboard() {
            return in.getClass() == System.in.getClass();
        }
        
        public LottoTicket askLottoNumbers(int count) {
            printlnWhenIsKeyBoard(count + "번째 로또번호를 입력해주세요.");
            
            String input = sc.nextLine();
            try {
                return LottoTicket.generateByUserInput(input);
            } catch (IllegalArgumentException e) {
                throw new IllegalStateException(e.getMessage());
            }
        }
        
        public LottoTicket askLottoNumbers() {
            return askLottoNumbers(0);
        }

        public LottoTicket askWinNumber() {
            printlnWhenIsKeyBoard("지난주 당첨번호를 입력해 주세요");
            String input = sc.nextLine();
            try {
                return LottoTicket.generateByUserInput(input);
            } catch (IllegalArgumentException e) {
                throw new IllegalStateException(e.getMessage());
            }
        }

        public LottoNumber askBonusNumber() {
            printlnWhenIsKeyBoard("지난주 보너스번호를 입력해 주세요");
            
            if (!sc.hasNextInt()) {
                throw new InputMismatchException("보너스번호는 숫자를 입력해야합니다.");
            }
            
            int input = sc.nextInt();
            try {
                return LottoNumber.valueOf(input);
            } catch (IllegalArgumentException e) {
                throw new IllegalStateException(e.getMessage());
            }
        }
    }
}