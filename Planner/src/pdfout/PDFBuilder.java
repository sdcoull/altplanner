package pdfout;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import model.IDay;
import model.IPeriod;
import model.IWeek;

public class PDFBuilder {

	public void create(IWeek week) {
		try {
			PDDocument document = new PDDocument();
			PDPage page = new PDPage();
			document.addPage( page );

			PDFont font = PDType1Font.HELVETICA_BOLD;

			PDPageContentStream contentStream = new PDPageContentStream(document, page);
			
			contentStream.beginText();
			contentStream.setFont( font, 12 );
			
			int xPos = 20;
			int yPos = 20;
			contentStream.moveTextPositionByAmount( xPos, yPos );
			for(int i = 0; i < 5; i++)
			{
				IDay day = week.getDay(i);
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				contentStream.drawString(sdf.format(day.getDate().getTime()));
				contentStream.moveTextPositionByAmount(10, 0);
				
				List<IPeriod> classes = day.getPeriods();
				for(IPeriod period : classes)
				{
					contentStream.drawString(period.getClassName());
					contentStream.moveTextPositionByAmount(10, 0);
				}
				contentStream.moveTextPositionByAmount(-60, 10);
			}
			
			contentStream.drawString( "Done" );
			contentStream.endText();

			contentStream.close();

			document.save( "Hello World.pdf");
			document.close();

			//		PDFMergerUtility finalDoc = new PDFMergerUtility(); 
			//		    PDDocument document = PDDocument.load("template.pdf");
			//		    PDPage page = (PDPage) document.getDocumentCatalog().getAllPages().get(0);
			//		    PDPageContentStream contentStream = new PDPageContentStream(document, page, true, true);
			//
			//		    contentStream.beginText();
			//		    // Draw stuff
			//		    contentStream.endText();
			//
			//		    contentStream.close();
			//
			//		    ByteArrayOutputStream out = new ByteArrayOutputStream();
			//		    document.save(out);
			//		    finalDoc.addSource(new ByteArrayInputStream(out.toByteArray()));
			//		    document.close();
			//
			//		response.setContentType("application/pdf");
			//		finalDoc.setDestinationStream(response.getOutputStream());
			//		finalDoc.mergeDocuments();
		} catch (COSVisitorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
