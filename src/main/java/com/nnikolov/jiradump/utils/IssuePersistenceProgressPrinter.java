package com.nnikolov.jiradump.utils;

public class IssuePersistenceProgressPrinter {

    public void printNextPage() {
        System.out.println();
        System.out.println("Fetch next page of issues");
    }

    public void printStart() {
        System.out.println();
        System.out.print("Starting persistence of multiple files");
    }

    public void printProgress(int allSaved, int allToSave) {
        System.out.print("\r");
        System.out.print(String.format("Processed %d of %d issues...", allSaved, allToSave));
    }

    public void printDone() {
        System.out.println();
        System.out.print("Done");
    }

    public void printDoneWithComment(int totalSaved, int total) {
        System.out.println();
        System.out.print("Done. " + (total - totalSaved) + " issues could not be persisted");
    }
}
