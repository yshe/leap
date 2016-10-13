package com.yabushan.test.util.word.poi;


import java.io.*;
import java.text.DateFormat;
import java.util.*;
import java.util.logging.*;

import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;


public class BooksToWordService {
    private BookDao dao;
    public BooksToWordService() {
        dao = new BookDao();
    }
    public List getBooks() {
        List books = new ArrayList();
        try {
            books = dao.getBooks();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return books;
    }
public void downloadWordDoc(OutputStream out) {
    try {
        List books = getBooks();                    // ��ȡ����ͼ����Ϣ
        StringBuilder sb = new StringBuilder();     // �����ַ������
        for (Object obj : books) {                  // ����ͼ����ݼ���
            BookBean book = (BookBean) obj;
            sb.append("��ţ�");                     // ���ͼ����Ϣ���ַ������
            sb.append(book.getISBN() + "\n");
            sb.append("����");
            sb.append(book.getBookName() + "\n");
            sb.append("���ߣ�");
            sb.append(book.getWriter() + "\n");
            sb.append("�����磺");
            sb.append(book.getPublishing() + "\n");
            sb.append("���ۣ�");
            sb.append(book.getPrice() + "\n");
            sb.append("����ʱ�䣺");
            Date date = book.getDate();
            // �������ڸ�ʽ������
            DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
            sb.append(df.format(date) + "\n");
            sb.append("\n");
        }
        writeWordDoc(sb.toString(),out);            // ��ͼ����Ϣд�뵽�����
    } catch (Exception ex) {
        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
    }
}

    private void writeWordDoc(String content,OutputStream ostream) {
        ByteArrayInputStream bais = null;                   // �����ֽ�����������
        try {
            byte[] b = content.getBytes();                  // ��ȡ�ַ���ֽ�����
            bais = new ByteArrayInputStream(b);             // ��ʱ���ֽ�����������
            POIFSFileSystem fs = new POIFSFileSystem();     // ����POI���ļ�ϵͳ����
            DirectoryEntry directory = fs.getRoot();        // ��ȡĿ¼����
            // �����ĵ�����
            DocumentEntry de = directory.createDocument("WordDocument", bais);
           
            fs.writeFilesystem(ostream);                    // �����д�뵽�����
        } catch (IOException e) {
            e.printStackTrace();
        } finally {                                         // �ͷ���Դ
            try {
                if (bais != null) {
                    bais.close();
                }
                if (ostream != null) {
                    ostream.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(BooksToWordService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
