package com.function;

import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobStorageException;
import com.microsoft.azure.functions.annotation.*;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.microsoft.azure.functions.*;

/**
 * Azure Functions with Azure Blob trigger.
 */
public class BlobTriggerFunction {

    private BlobServiceClient blobServiceClient;

//    public BlobTriggerFunction() {
//        blobServiceClient = new BlobServiceClientBuilder()
//                .credential(new DefaultAzureCredentialBuilder().build())
//                .endpoint("https://<your-storage-account-name>.blob.core.windows.net")
//                .buildClient();
//    }

public BlobTriggerFunction() {
    blobServiceClient = new BlobServiceClientBuilder()
            .credential(new DefaultAzureCredentialBuilder().build())
            .endpoint("http://127.0.0.1:10000/devstoreaccount1")
            .buildClient();
}

    @FunctionName("BlobTriggerFunction")
    @StorageAccount("AzureWebJobsStorage")
    public void run(
        @BlobTrigger(name = "content", path = "localblobcontainer/{name}", dataType = "binary") byte[] content,
        @BindingName("name") String fileName,
        final ExecutionContext context
    ) {
        context.getLogger().info("Java Blob trigger function processed a blob. Name: " + fileName + "\n  Size: " + content.length + " Bytes");
      //  try {
     //       blobServiceClient.getBlobContainerClient("localblobcontainer")
     //               .getBlobClient(fileName)
     //               .copyFromUrl("http://127.0.0.1:10000/devstoreaccount1/localblobcontainer/" + fileName);

    //        blobServiceClient.getBlobContainerClient("localblobcontainer")
     //               .getBlobClient(fileName)
     //               .delete();
//
 //           context.getLogger().info("File copied and deleted successfully.");
  //      } catch (BlobStorageException e) {
   //         context.getLogger().severe("Error processing blob: " + e.getMessage());
    //    }
    }
}
