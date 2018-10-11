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
            lottos[i] = asker.askLottoTicketNumber(i + 1);
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
            if (isKeyboard()) {
                print("구매금액을 입력해 주세요");
            }
            
            int money = nextInt();
            if (money % LottoTicket.MONEY_PER_TICKET != 0) {
                throw new IllegalStateException("구매금액은 " + LottoTicket.MONEY_PER_TICKET + "원 단위입니다");
            }
            
            return money;
        }
        
        private void print(String str) {
            try {
                out.write((str + "\n").getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        private int nextInt() {
            if (!sc.hasNextInt()) {
                throw new InputMismatchException("숫자를 입력해야합니다.");
            }
            
            int input = sc.nextInt();
            if (sc.hasNextLine()) {
                sc.nextLine();
            }
            return input;
        }

        private boolean isKeyboard() {
            return in.getClass() == System.in.getClass();
        }
        
        public LottoTicket askLottoTicketNumber(int count) {
            if (isKeyboard()) {
                print(count + "번째 로또번호를 입력해주세요.");
            }
            
            String lottoNumber = sc.nextLine();
            try {
                return LottoTicket.generateByUserInput(lottoNumber);
            } catch (IllegalArgumentException e) {
                throw new IllegalStateException(e.getMessage());
            }
        }
        
        public LottoTicket askLottoTicketNumber() {
            return askLottoTicketNumber(0);
        }

        public LottoTicket askWinNumber() {
            if (isKeyboard()) {
                print("지난주 당첨번호를 입력해 주세요");
            }
            
            String winNumber = sc.nextLine();
            try {
                return LottoTicket.generateByUserInput(winNumber);
            } catch (IllegalArgumentException e) {
                throw new IllegalStateException(e.getMessage());
            }
        }

        public LottoNumber askBonusNumber() {
            if (isKeyboard()) {
                print("지난주 보너스번호를 입력해 주세요");
            }
            
            int bonusNumber = nextInt();
            try {
                return LottoNumber.valueOf(bonusNumber);
            } catch (IllegalArgumentException e) {
                throw new IllegalStateException(e.getMessage());
            }
        }
    }
}