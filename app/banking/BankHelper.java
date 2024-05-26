package app.banking;

import app.banking.domain.BankAccount;
import app.banking.domain.BankEntry;
import app.banking.observers.BankEmailSender;
import app.banking.rules.*;
import app.framework.domain.Observer;
import app.framework.rules.BankRuleEngine;
import app.framework.rules.Rule;

import java.util.ArrayList;
import java.util.List;

public class BankHelper {

    public static BankRuleEngine getRuleEngine(){
        BankRuleEngine engine = new BankRuleEngine();
        engine.addRule(new FraudDetectionRule(BankHelper.getObservers()));
        return engine;
    }

    public static List<Rule<BankAccount, BankEntry>> getWithdrawRules(){
        List<Observer> obs = new ArrayList<>();
        obs.add(BankEmailSender.getInstance());
        List<Rule<BankAccount,BankEntry>> rules = new ArrayList<>();
        rules.add(new FraudDetectionRule(obs));
        rules.add( new CompanyBankAccountWithdrawNotifyRule(obs) );
        rules.add( new CompanyBankAccountWithdrawSufficientBalanceRule(obs) );
        rules.add( new PersonalBankAccountWithDrawNotifyRule(obs) );
        rules.add( new PersonalBankAccountWithdrawSufficientBalanceRule(obs) );
        return rules;
    }

    public static List<Rule<BankAccount,BankEntry>> getDepositRules(){
        List<Observer> obs = new ArrayList<>();
        obs.add(BankEmailSender.getInstance());
        List<Rule<BankAccount,BankEntry>> rules = new ArrayList<>();
        rules.add( new FraudDetectionRule(obs) );
        rules.add( new CompanyBankAccountDepositNotifyRule(obs) );
        rules.add( new PersonalBankAccountDepositNotifyRule(obs) );
        return rules;
    }

    public static List<Observer> getObservers(){
        return new ArrayList<Observer>(){
            {
                add(BankEmailSender.getInstance());
            }
        };
    }

}
