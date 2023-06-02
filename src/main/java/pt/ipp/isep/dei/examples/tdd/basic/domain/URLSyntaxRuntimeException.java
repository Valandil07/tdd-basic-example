package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.net.URISyntaxException;

public class URLSyntaxRuntimeException extends RuntimeException {
    public URLSyntaxRuntimeException(URISyntaxException statement){
        super(statement);
    }
}
