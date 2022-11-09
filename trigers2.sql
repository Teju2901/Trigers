use trigers1;
create table account(Account_No int primary key auto_increment, Acc_Name varchar(30) not null, Balance numeric(10,2));
create table account_udpate (Account_No int not null ,
Acc_Name varchar(30) not null,
changed_id timestamp,
before_Bal numeric(10,2) not null,
after_Bal numeric(10,2) not null,
Actions varchar(10) null,
Transaction_amt int null);
insert into account(Acc_Name, Balance ) values('tejesh',20000.00);
delimiter $$
create trigger after_bank_update1 after update on account for each row
begin
if(new.Balance<old.Balance) then
	insert into account_udpate(Account_No , Acc_Name , changed_id , before_Bal , after_Bal, Actions, Transaction_amt ) 
	values(old.Account_No, old.Acc_Name, now(), old.Balance , new.Balance, 'Debit',-(old.Balance-new.Balance));
end IF;
end $$
delimiter $$
create trigger after_bank_update2 after update on account for each row
begin
if(new.Balance>old.Balance) then
	insert into account_udpate(Account_No , Acc_Name , changed_id , before_Bal , after_Bal, Actions ,Transaction_amt) 
	values(old.Account_No, old.Acc_Name, now(), old.Balance , new.Balance, 'Credit',+(new.Balance-old.Balance));
end IF;
end $$
update account set Balance = (Balance-8000) where Account_No = 1;
update account set Balance = (Balance+15000) where Account_No = 1;
drop trigger after_bank_update1;
drop trigger after_bank_update2;

DELIMITER $$
CREATE PROCEDURE HOURLY_ADD (IN Account_No INT, OUT WTotal numeric(10,2), OUT DTotal numeric(10,2))
BEGIN
    SELECT sum(Transaction_amt) INTO WTotal FROM trigers1.account_udpate
	WHERE Actions = 'Debit' AND Account_No=Account_No AND changed_id >= Date_sub(now(),interval 1 hour);
    
    SELECT sum(Transaction_amt) INTO DTotal FROM trigers1.account_udpate
	WHERE Actions = 'Credit' AND Account_No=Account_No AND changed_id >= Date_sub(now(),interval 1 hour);
END $$

CALL HOURLY_ADD(1, @WTotal, @DTotal);

SELECT @WTotal, @DTotal;
DROP PROCEDURE HOURLY_ADD;