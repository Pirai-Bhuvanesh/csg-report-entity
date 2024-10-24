CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS templates (
    uuid UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    template_name VARCHAR(255) NOT NULL,
    created_by VARCHAR(255),
    modified_by VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS method_rules (
    uuid UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    method_name VARCHAR(255) NOT NULL,
    created_by VARCHAR(255),
    modified_by VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS reports (
    uuid UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    report_name VARCHAR(255) NOT NULL,
    email_required BOOLEAN NOT NULL,
    fresh_works BOOLEAN NOT NULL,
    manager_mail BOOLEAN NOT NULL,
    template_id UUID NOT NULL,
    created_by VARCHAR(255),
    modified_by VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS reports_column (
    uuid UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    column_name VARCHAR(255) NOT NULL,
    column_number INTEGER NOT NULL,
    data_type VARCHAR(255) NOT NULL,
    report_id UUID,
    report_name VARCHAR(255) NOT NULL,
    created_by VARCHAR(255),
    modified_by VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS reports_request_list (
    uuid UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    file_format VARCHAR(50) NOT NULL,
    file_name VARCHAR(255) NOT NULL,
    report_id UUID,
    error_response TEXT,
    s3_key VARCHAR(255),
    status VARCHAR(50) NOT NULL,
    successful_row_count INT DEFAULT 0,
    unsuccessful_row_count INT DEFAULT 0,
    total_row_count INT DEFAULT 0,
    created_by VARCHAR(255),
    modified_by VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS report_rules (
    uuid UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    column_uuid UUID NOT NULL,
    rule_method_uuid UUID NOT NULL,
    report_id UUID,
    report_name VARCHAR(255) NOT NULL,
    created_by VARCHAR(255),
    modified_by VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS report_meta_data (
    uuid UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    data JSONB,
    report_meta_data_uuid UUID,
    created_by VARCHAR(255),
    modified_by VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


INSERT INTO templates (template_name, created_by, modified_by)
VALUES ('admin', null, null);

INSERT INTO method_rules (method_name, created_by, modified_by)
VALUES ('isNotNullOrEmpty', null, null);

INSERT INTO method_rules (method_name, created_by, modified_by)
VALUES ('isInteger', null, null);

INSERT INTO method_rules (method_name, created_by, modified_by)
VALUES ('isString', null, null);

INSERT INTO method_rules (method_name, created_by, modified_by)
VALUES ('isFloat', null, null);

INSERT INTO method_rules (method_name, created_by, modified_by)
VALUES ('isEmail', null, null);

