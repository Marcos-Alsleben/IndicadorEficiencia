/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ie.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gmg
 */
public class Utilitarios {

// Metodo Pegar Data e Hora
    public String DH() {
        Date data = new Date();
        SimpleDateFormat formatar = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataFormatada = formatar.format(data);

        //JOptionPane.showMessageDialog(null, dataFormatada);
        return dataFormatada;

    }

// Metodo Gerar pdf da tabela
    public static void gerarPDF(JTable tabela, String nomeArquivo, List<String> colunasIncluidas, String titulo) throws FileNotFoundException, DocumentException, IOException {
        File arquivo = new File(nomeArquivo);

        // Definindo o documento em modo paisagem
        Document documento = new Document(PageSize.A4.rotate(), 10, 10, 10, 20); // Ajustar margens aqui
        PdfWriter writer = PdfWriter.getInstance(documento, new FileOutputStream(nomeArquivo));
        writer.setPageEvent(new PageNumberEvent());
        documento.open();

        PdfPTable pdfTable = new PdfPTable(colunasIncluidas.size());
        pdfTable.setWidthPercentage(100); // Define a largura da tabela para 100% da página

        // Definindo as fontes
        com.lowagie.text.Font fonteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14);
        com.lowagie.text.Font fonteCabecalho = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 11);
        com.lowagie.text.Font fonteDados = FontFactory.getFont(FontFactory.HELVETICA, 9);

        // Adicionando cabeçalhos
        for (String coluna : colunasIncluidas) {
            PdfPCell cell = new PdfPCell(new Paragraph(coluna, fonteCabecalho));
            cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            pdfTable.addCell(cell);
        }

        // Adicionando dados
        for (int rows = 0; rows < tabela.getRowCount(); rows++) {
            for (String coluna : colunasIncluidas) {
                int colIndex = tabela.getColumnModel().getColumnIndex(coluna);
                PdfPCell cell = new PdfPCell(new Paragraph(tabela.getModel().getValueAt(rows, colIndex).toString(), fonteDados));
                cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                pdfTable.addCell(cell);
            }
        }

        // Adicionando título e linha vazia
        Paragraph tituloParagrafo = new Paragraph(titulo, fonteTitulo);
        tituloParagrafo.setAlignment(Element.ALIGN_CENTER); // Centralizando o título 
        documento.add(tituloParagrafo);
        documento.add(new Paragraph(" ")); // Linha vazia 
        documento.add(pdfTable);
        documento.close();

        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().open(arquivo);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class PageNumberEvent extends PdfPageEventHelper {

        @Override
        public void onEndPage(PdfWriter writer, Document document) {
            int pageNumber = writer.getPageNumber();
            String footer = "Página " + pageNumber;
            Phrase footerPhrase = new Phrase(footer, FontFactory.getFont(FontFactory.HELVETICA, 9));
            ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, footerPhrase,
                    (document.right() - document.left()) / 2 + document.leftMargin(),
                    document.bottom() - 10, 0); // Ajustar a margem inferior aqui
        }
    }

}
