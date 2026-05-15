package br.com.planet.metas.service.report;

import br.com.planet.metas.dto.MetaReportData;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
public class MetaReportService {

    public byte[] generateSpreadsheet(List<MetaReportData> reportData) {
        try (
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream()
        ) {
            Sheet sheet = workbook.createSheet("Metas");

            CellStyle headerStyle = createHeaderStyle(workbook);
            CellStyle dateStyle = createDateStyle(workbook);
            CellStyle moneyStyle = createMoneyStyle(workbook);

            createHeader(sheet, headerStyle);
            fillData(sheet, reportData, dateStyle, moneyStyle);
            autoSizeColumns(sheet);

            workbook.write(outputStream);

            return outputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao gerar planilha de metas: ", e);
        }
    }

    private void createHeader(Sheet sheet, CellStyle headerStyle) {
        Row header = sheet.createRow(0);

        createCell(header, 0, "Data Instalação", headerStyle);
        createCell(header, 1, "Contrato", headerStyle);
        createCell(header, 2, "Cliente", headerStyle);
        createCell(header, 3, "Plano", headerStyle);
        createCell(header, 4, "Vendedor", headerStyle);
        createCell(header, 5, "Ticket", headerStyle);
    }

    private void fillData(
            Sheet sheet,
            List<MetaReportData> reportData,
            CellStyle dateStyle,
            CellStyle moneyStyle
    ) {
        if (reportData == null || reportData.isEmpty()) {
            return;
        }

        int rowIndex = 1;

        for (MetaReportData data : reportData) {
            Row row = sheet.createRow(rowIndex++);

            createDateCell(row, 0, data.getDataInstalacao(), dateStyle);
            createLongCell(row, 1, data.getIdContrato());
            createStringCell(row, 2, data.getNomeCliente());
            createStringCell(row, 3, data.getNomePlano());
            createStringCell(row, 4, data.getNomeVendedor());
            createMoneyCell(row, 5, data.getTicket(), moneyStyle);
        }
    }

    private void createCell(Row row, int column, String value, CellStyle style) {
        Cell cell = row.createCell(column);
        cell.setCellValue(value);
        cell.setCellStyle(style);
    }

    private void createStringCell(Row row, int column, String value) {
        Cell cell = row.createCell(column);
        cell.setCellValue(value != null ? value : "");
    }

    private void createLongCell(Row row, int column, Long value) {
        Cell cell = row.createCell(column);

        if (value != null) {
            cell.setCellValue(value);
        } else {
            cell.setCellValue("");
        }
    }

    private void createDateCell(Row row, int column, LocalDate value, CellStyle style) {
        Cell cell = row.createCell(column);

        if (value != null) {
            cell.setCellValue(value);
            cell.setCellStyle(style);
        } else {
            cell.setCellValue("");
        }
    }

    private void createMoneyCell(Row row, int column, Double value, CellStyle style) {
        Cell cell = row.createCell(column);

        if (value != null) {
            cell.setCellValue(value);
            cell.setCellStyle(style);
        } else {
            cell.setCellValue(0.0);
            cell.setCellStyle(style);
        }
    }

    private CellStyle createHeaderStyle(Workbook workbook) {
        Font font = workbook.createFont();
        font.setBold(true);

        CellStyle style = workbook.createCellStyle();
        style.setFont(font);

        return style;
    }

    private CellStyle createDateStyle(Workbook workbook) {
        CreationHelper creationHelper = workbook.getCreationHelper();

        CellStyle style = workbook.createCellStyle();
        style.setDataFormat(
                creationHelper.createDataFormat().getFormat("dd/mm/yyyy")
        );

        return style;
    }

    private CellStyle createMoneyStyle(Workbook workbook) {
        CreationHelper creationHelper = workbook.getCreationHelper();

        CellStyle style = workbook.createCellStyle();
        style.setDataFormat(
                creationHelper.createDataFormat().getFormat("R$ #,##0.00")
        );

        return style;
    }

    private void autoSizeColumns(Sheet sheet) {
        for (int column = 0; column <= 5; column++) {
            sheet.autoSizeColumn(column);
        }
    }

}
