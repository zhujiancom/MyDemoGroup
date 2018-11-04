package com.zj.demo.batch.service;

import com.zj.demo.beans.Transaction;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Creator: zhuji
 * Date: 11/4/2018
 * Time: 12:42 AM
 * Description:
 */
public class RecordFieldSetMapper implements FieldSetMapper<Transaction> {
    @Override
    public Transaction mapFieldSet(FieldSet fieldSet) throws BindException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Transaction transaction = new Transaction();
        // you can either use the indices or custom names
        // I personally prefer the custom names easy for debugging and
        // validating the pipelines
        transaction.setUsername(fieldSet.readString("username"));
        transaction.setUserId(fieldSet.readInt("userid"));
        transaction.setAmount(fieldSet.readDouble(3));
        // Converting the date
        String dateString = fieldSet.readString(2);
        try {
            transaction.setTransactionDate(dateFormat.parse(dateString));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return transaction;
    }
}
